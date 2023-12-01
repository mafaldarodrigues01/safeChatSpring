package fcul.mei.safeChat.Encryption;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.sql.Array;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Properties;

import cn.edu.buaa.crypto.access.parser.ParserUtils;

import it.unisa.dia.gas.jpbc.PairingParametersGenerator;
import it.unisa.dia.gas.plaf.jpbc.pairing.parameters.PropertiesParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import cn.edu.buaa.crypto.access.parser.PolicySyntaxException;
import cn.edu.buaa.crypto.algebra.serparams.PairingCipherSerParameter;
import cn.edu.buaa.crypto.algebra.serparams.PairingKeyEncapsulationSerPair;
import cn.edu.buaa.crypto.algebra.serparams.PairingKeySerPair;
import cn.edu.buaa.crypto.algebra.serparams.PairingKeySerParameter;
import cn.edu.buaa.crypto.encryption.abe.kpabe.KPABEEngine;
import cn.edu.buaa.crypto.encryption.abe.kpabe.gpsw06a.KPABEGPSW06aEngine;
import cn.edu.buaa.crypto.encryption.ibe.IBEEngine;
import cn.edu.buaa.crypto.encryption.ibe.bf01a.IBEBF01aEngine;
import cn.edu.buaa.crypto.utils.PairingUtils;
import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.Pairing;
import it.unisa.dia.gas.jpbc.PairingParameters;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;

public class EncriptionABE {

    String group;

    List<String> users;

    public static void testKPABE() throws PolicySyntaxException, IOException, InvalidCipherTextException {
        //setup
        KPABEEngine engine = KPABEGPSW06aEngine.getInstance();
        PairingParameters pairingParameters = PairingFactory.getInstance().loadParameters("params/a_160_512.properties");
        Pairing pairing = PairingFactory.getPairing(pairingParameters);

        //keygen - done by the PKG
        PairingKeySerPair keyPair = engine.setup(pairingParameters,50);
        PairingKeySerParameter publicKey = keyPair.getPublic();
        PairingKeySerParameter masterKey = keyPair.getPrivate();
        String policy = "0 and 1 and (2 or 3)";
        int[][] accessPolicy = ParserUtils.GenerateAccessPolicy(policy);
        String[] rhos = ParserUtils.GenerateRhos(policy);
        PairingKeySerParameter secretKey = engine.keyGen(publicKey,masterKey,accessPolicy,rhos);

        //encryption - done by Alice
        String[] attributes = new String[] {"0", "1", "2"};
        Element message = PairingUtils.MapStringToGroup(pairing,"ola",PairingUtils.PairingGroupType.GT);

        PairingCipherSerParameter ciphertext = engine.encryption(publicKey,attributes,message);//encrypt
        // decryption - done by Bob
        Element anMessage = engine.decryption(publicKey,secretKey,attributes,ciphertext);//decrypt

        Element[] a = {message};
        Element[] c = {anMessage};
        System.out.println(message);
        String[] b = PairingUtils.MapElementArrayToStringArray(a);
        System.out.println(b[0]);
        String[] b1 = PairingUtils.MapElementArrayToStringArray(c);
        System.out.println(b1[0]);
        System.out.println("Mensagem original: " + PairingUtils.MapElementArrayToStringArray(a)[0]);
        System.out.println("Mensagem descriptografada: " + PairingUtils.MapElementArrayToStringArray(c)[0]);


    }

    public static void main (String args[]) throws Exception {
        System.out.println("=============");
        System.out.println("Testing KP-ABE encryption!");
        System.out.println("=============");
        testKPABE();
        System.out.println();
    }
}

package fcul.mei.safeChat.com.blockchain;

import java.util.Date;

public class Block {

    public String hash;
    public String previousHash;
    private Data data;
    private long timeStamp;

    public Block(Data data, String previousHash) {
        this.data = data;
        this.previousHash
                = previousHash;
        this.timeStamp
                = new Date().getTime();
        this.hash
                = calculateHash();
    }

    public String calculateHash() {
        return Crypt.sha256(previousHash + timeStamp + data);
    }
}
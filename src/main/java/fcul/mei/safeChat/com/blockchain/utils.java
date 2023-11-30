package fcul.mei.safeChat.com.blockchain;

import java.util.ArrayList;

public class utils {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();

    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        for (int i = 1; i < blockchain.size(); i++) {

            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);

            if (!currentBlock.hash
                    .equals(
                            currentBlock
                                    .calculateHash())) {
                System.out.println(
                        "Hashes are not equal");
                return false;
            }

            if (!previousBlock
                    .hash
                    .equals(
                            currentBlock
                                    .previousHash)) {
                System.out.println(
                        "Previous Hashes are not equal");
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
   /*     blockchain.add(new Block(
                "First block", "0"));
        blockchain.add(new Block(
                "Second block",
                blockchain
                        .get(blockchain.size() - 1)
                        .hash));

        blockchain.add(new Block(
                "Third block",
                blockchain
                        .get(blockchain.size() - 1)
                        .hash));

        blockchain.add(new Block(
                "Fourth block",
                blockchain
                        .get(blockchain.size() - 1)
                        .hash));
        blockchain.add(new Block(
                "Fifth block",
                blockchain
                        .get(blockchain.size() - 1)
                        .hash));*/
    }
}

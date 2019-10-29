package au.csiro.data61.aap.rpc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * EthereumLog
 */
public class EthereumLog {
    private final EthereumTransaction tx;
    private final boolean removed;
    private final String address;
    private final String data;
    private final List<String> topics;
    
    EthereumLog(
        EthereumTransaction tx,
        boolean removed,
        String address,
        String data,
        List<String> topics
    )
    {
        this.tx = tx;
        this.removed = removed;
        this.address = address;
        this.data = data;
        this.topics = topics == null ? new ArrayList<>() : new ArrayList<>(topics);
    }

    public String getAddress() {
        return address;
    }

    public String getData() {
        return data;
    }

    public boolean isRemoved() {
        return removed;
    }

    public EthereumTransaction getTransaction() {
        return this.tx;
    }

    public String getTransactionHash() {
        return this.tx.getHash();
    }

    public String getTransactionIndex() {
        return this.tx.getTransactionIndex();
    }

    public String getBlockHash() {
        return this.tx.getBlockHash();
    }

    public String getBlockNumber() {
        return this.tx.getBlockNumber();
    }

    public int topicCount() {
        return this.topics.size();
    }

    public String getTopic(int index) {
        assert 0 <= index && index < this.topicCount();
        return this.topics.get(index);
    }

    public Stream<String> topicStream() {
        return this.topics.stream();
    }
}
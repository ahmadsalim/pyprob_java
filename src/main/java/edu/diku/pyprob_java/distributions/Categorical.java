package edu.diku.pyprob_java.distributions;

import ch.ethz.idsc.tensor.Tensor;
import edu.diku.pyprob_java.MessageHandler;

public class Categorical implements IntegerDistribution {
    private Tensor probs;

    public Categorical(Tensor probs) {
        this.probs = probs;
    }

    public Tensor getProbs() {
        return probs;
    }

    public void setProbs(Tensor probs) {
        this.probs = probs;
    }

    @Override
    public byte fbDistType() {
        return ppx.Distribution.Categorical;
    }

    @Override
    public int fbCreateDist(MessageHandler messageHandler) {
        var builder = messageHandler.getBuilder();
        var mProbs = messageHandler.protocolTensor(this.probs);
        return ppx.Categorical.createCategorical(builder, mProbs);
    }
}

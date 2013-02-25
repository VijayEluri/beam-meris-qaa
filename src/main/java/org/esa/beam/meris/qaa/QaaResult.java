package org.esa.beam.meris.qaa;

public class QaaResult {

    private static final int FLAG_MASK_VALID = 0x0001;
    private static final int FLAG_MASK_NEGATIVE_AYS= 0x0004;
    private static final int FLAG_MASK_A_TOTAL_OOB = 0x0010;
    private static final int FLAG_MASK_BB_SPM_OOB = 0x0020;
    private static final int FLAG_MASK_A_PIG_OOB = 0x0040;
    private static final int FLAG_MASK_A_YS_OOB = 0x0080;

    private float[] A_Total;
    private float[] BB_SPM;
    private float[] A_PIG;
    private float[] A_YS;
    private int flags;

    public QaaResult() {
        A_Total = new float[QaaConstants.NUM_A_TOTAL_BANDS];
        BB_SPM = new float[QaaConstants.NUM_BB_SPM_BANDS];
        A_PIG = new float[QaaConstants.NUM_A_PIG_BANDS];
        A_YS = new float[QaaConstants.NUM_A_YS_BANDS];

        setValid(true);
    }

    public void setA_Total(float a_total, int bandIndex) {
        A_Total[bandIndex] = a_total;
    }

    public float[] getA_Total() {
        return A_Total;
    }

    public void setBB_SPM(float bb_spm, int bandIndex) {
        BB_SPM[bandIndex] = bb_spm;
    }

    public float[] getBB_SPM() {
        return BB_SPM;
    }

    public void setA_PIG(float a_pig, int bandIndex) {
        A_PIG[bandIndex] = a_pig;
    }

    public float[] getA_PIG() {
        return A_PIG;
    }

    public void setA_YS(float a_ys, int bandIndex) {
        A_YS[bandIndex] = a_ys;
    }

    public float[] getA_YS() {
        return A_YS;
    }

    @SuppressWarnings("PointlessBitwiseExpression")
    public void setValid(boolean valid) {
        if (valid) {
            flags |= FLAG_MASK_VALID;
        }  else {
            flags &= ~FLAG_MASK_VALID;
        }
    }

    public void setATotalOutOfBounds(boolean outOfBounds) {
        if (outOfBounds) {
            flags |= FLAG_MASK_A_TOTAL_OOB;
        }  else {
            flags &= ~FLAG_MASK_A_TOTAL_OOB;
        }
    }

    public void setBbSpmOutOfBounds(boolean outOfBounds) {
        if (outOfBounds) {
            flags |= FLAG_MASK_BB_SPM_OOB;
        }  else {
            flags &= ~FLAG_MASK_BB_SPM_OOB;
        }
    }

    public void setAPigOutOfBounds(boolean outOfBounds) {
        if (outOfBounds) {
            flags |= FLAG_MASK_A_PIG_OOB;
        }  else {
            flags &= ~FLAG_MASK_A_PIG_OOB;
        }
    }

    public int getFlags() {
        return flags;
    }

    public void setAYsOutOfBounds(boolean outOfBounds) {
        if (outOfBounds) {
            flags |= FLAG_MASK_A_YS_OOB;
        }  else {
            flags &= ~FLAG_MASK_A_YS_OOB;
        }
    }

    public void setAYsNegative(boolean isNegative) {
        if (isNegative) {
            flags |= FLAG_MASK_NEGATIVE_AYS;
        }  else {
            flags &= ~FLAG_MASK_NEGATIVE_AYS;
        }
    }
}
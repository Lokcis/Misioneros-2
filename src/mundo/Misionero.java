package mundo;

import gfutria.Logic;

/**
 *
 * @author asus
 */
public class Misionero extends Logic {

    private int misionerosIzq = 3, misionerosDer = 0, canibalesIzq = 3, canibalesDer = 0;
    private boolean bote = true;

    public Misionero() {
    }

    public Misionero(int misionerosIzq, int misionerosDer, int canibalesIzq, int canibalesDer, boolean bote) {
        this.misionerosIzq = misionerosIzq;
        this.misionerosDer = misionerosDer;
        this.canibalesIzq = canibalesIzq;
        this.canibalesDer = canibalesDer;
        this.bote = bote;
    }

    public int getMisionerosIzq() {
        return misionerosIzq;
    }

    public void setMisionerosIzq(int misionerosIzq) {
        this.misionerosIzq = misionerosIzq;
    }

    public int getMisionerosDer() {
        return misionerosDer;
    }

    public void setMisionerosDer(int misionerosDer) {
        this.misionerosDer = misionerosDer;
    }

    public int getCanibalesIzq() {
        return canibalesIzq;
    }

    public void setCanibalesIzq(int canibalesIzq) {
        this.canibalesIzq = canibalesIzq;
    }

    public int getCanibalesDer() {
        return canibalesDer;
    }

    public void setCanibalesDer(int canibalesDer) {
        this.canibalesDer = canibalesDer;
    }

    public boolean getBote() {
        return bote;
    }

    public void setBote(boolean bote) {
        this.bote = bote;
    }

    private boolean esEstadoValido() {
        boolean izquierdaValida = (misionerosIzq == 0 || misionerosIzq >= canibalesIzq);
        boolean derechaValida = (misionerosDer == 0 || misionerosDer >= canibalesDer);

        return izquierdaValida && derechaValida;

    }

    public void llevar1M() {
        if (bote && misionerosIzq > 0) {
            misionerosIzq--;
            misionerosDer++;
            bote = false;
        } else if (!bote && misionerosDer > 0) {
            misionerosDer--;
            misionerosIzq++;
            bote = true;
        }

        if (!esEstadoValido()) {
            // Revertir movimiento
            if (!bote) {
                misionerosDer--;
                misionerosIzq++;
                bote = true;
            } else {
                misionerosIzq--;
                misionerosDer++;
                bote = false;
            }
        }
    }

    public void llevar2M() {
        if (bote && misionerosIzq >= 2) {
            misionerosIzq -= 2;
            misionerosDer += 2;
            bote = false;
        } else if (!bote && misionerosDer >= 2) {
            misionerosDer -= 2;
            misionerosIzq += 2;
            bote = true;
        }

        if (!esEstadoValido()) {
            if (!bote) {
                misionerosIzq += 2;
                misionerosDer -= 2;
                bote = true;
            } else {
                misionerosDer += 2;
                misionerosIzq -= 2;
                bote = false;
            }
        }
    }

    public void llevar1C() {
        if (bote && canibalesIzq > 0) {
            canibalesIzq--;
            canibalesDer++;
            bote = false;
        } else if (!bote && canibalesDer > 0) {
            canibalesDer--;
            canibalesIzq++;
            bote = true;
        }

        if (!esEstadoValido()) {
            if (!bote) {
                canibalesIzq++;
                canibalesDer--;
                bote = true;
            } else {
                canibalesDer++;
                canibalesIzq--;
                bote = false;
            }
        }
    }

    public void llevar2C() {
        if (bote && canibalesIzq >= 2) {
            canibalesIzq -= 2;
            canibalesDer += 2;
            bote = false;
        } else if (!bote && canibalesDer >= 2) {
            canibalesDer -= 2;
            canibalesIzq += 2;
            bote = true;
        }

        if (!esEstadoValido()) {
            if (!bote) {
                canibalesIzq += 2;
                canibalesDer -= 2;
                bote = true;
            } else {
                canibalesDer += 2;
                canibalesIzq -= 2;
                bote = false;
            }
        }
    }

    public void llevarMC() {
        if (bote && misionerosIzq > 0 && canibalesIzq > 0) {
            misionerosIzq--;
            canibalesIzq--;
            misionerosDer++;
            canibalesDer++;
            bote = false;
        } else if (!bote && misionerosDer > 0 && canibalesDer > 0) {
            misionerosDer--;
            canibalesDer--;
            misionerosIzq++;
            canibalesIzq++;
            bote = true;
        }

        if (!esEstadoValido()) {
            if (!bote) {
                misionerosIzq++;
                canibalesIzq++;
                misionerosDer--;
                canibalesDer--;
                bote = true;
            } else {
                misionerosDer++;
                canibalesDer++;
                misionerosIzq--;
                canibalesIzq--;
                bote = false;
            }
        }
    }

    @Override
    public Logic cloneObject(Logic logic) {
        Misionero objMisioneros = (Misionero) logic;
        Misionero misioneroClone = new Misionero();

        misioneroClone.setBote(objMisioneros.getBote());
        misioneroClone.setCanibalesDer(objMisioneros.getCanibalesDer());
        misioneroClone.setCanibalesIzq(objMisioneros.getCanibalesIzq());
        misioneroClone.setMisionerosDer(objMisioneros.getMisionerosDer());
        misioneroClone.setMisionerosIzq(objMisioneros.getMisionerosIzq());

        return misioneroClone;

    }

    @Override
    public String state() {

        return misionerosIzq + "M " + canibalesIzq + "C " + misionerosDer + "M " + canibalesDer + "C " + bote;

    }

    @Override
    public void action(int i) {
        switch (i) {
            case 1:
                llevar1M();
                break;
            case 2:
                llevar2M();
                break;
            case 3:
                llevar1C();
                break;
            case 4:
                llevar2C();
                break;
            case 5:
                llevarMC();
                break;
        }
    }
}

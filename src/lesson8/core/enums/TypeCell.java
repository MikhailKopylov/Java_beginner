package lesson8.core.enums;

public enum TypeCell {

    EMPTY, X, O;

    public TypeCell reverseTypeCell(){
        switch (this){
            case X:
                return O;
            case O:
                return X;
            default: return EMPTY;
        }
    }

}

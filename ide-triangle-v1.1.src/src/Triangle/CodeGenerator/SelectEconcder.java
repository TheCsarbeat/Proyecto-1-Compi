package Triangle.CodeGenerator;

import java.util.List;

public class SelectEconcder {
    public SelectEconcder(int caseType, Object o) {
        this.caseType = caseType;
        this.o = o;
    
    }

    public void setLastCase(Boolean lastCase) {
        this.lastCase = lastCase;
    }

    public int caseLevel;
    public Object o;
    public int caseType;
    public boolean lastCase;
    public List<Integer> jumpAddress;

    
}



// DATA REPRESENTATION



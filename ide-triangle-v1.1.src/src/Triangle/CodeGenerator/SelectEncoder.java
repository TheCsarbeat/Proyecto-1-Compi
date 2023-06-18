package Triangle.CodeGenerator;

import java.util.ArrayList;
import java.util.List;

import Triangle.AbstractSyntaxTrees.Command;

public class SelectEconcder {
    public SelectEconcder(Object o) {
        this.o = o;
        this.jumpAddress = new ArrayList<Integer>();
    
    }

    public void setLastCase(Boolean lastCase) {
        this.lastCase = lastCase;
    }

    public int caseLevel;
    public Object o;
    public int caseType;
    public boolean lastCase;
    public List<Integer> jumpAddress;
    public Command elseCommand;

    
}



// DATA REPRESENTATION



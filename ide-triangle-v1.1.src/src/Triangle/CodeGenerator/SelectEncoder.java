package Triangle.CodeGenerator;

import java.util.ArrayList;
import java.util.List;

import Triangle.AbstractSyntaxTrees.Command;

public class SelectEncoder {
    public SelectEncoder(Object o) {
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
    public int intLiteral1, intLiteral2;
    public char charLiteral1, charLiteral2;
    
}



// DATA REPRESENTATION



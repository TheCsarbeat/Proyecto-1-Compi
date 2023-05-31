/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.ContextualAnalyzer;
import Triangle.AbstractSyntaxTrees.TypeDenoter;
import Triangle.StdEnvironment;
import java.util.*; 
/**
 *
 * @author erks martinez
 */
public class SelectContextual {

    public SelectContextual(TypeDenoter type) {
        this.type = type;

        //if type is integer, then hash_Set must be integer
        if (type.equals(StdEnvironment.integerType)) {
            this.set = new HashSet<Integer>();
        }else{
            this.set = new HashSet<Character>();
        }
        
        
    }
    
    
    public Set set;
    public TypeDenoter type;
}

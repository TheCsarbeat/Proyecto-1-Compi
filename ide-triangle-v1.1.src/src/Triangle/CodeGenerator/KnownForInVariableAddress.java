/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.CodeGenerator;

/**
 *
 * @author Sebastian
 */
public class KnownForInVariableAddress extends RuntimeEntity{
  
    int elemSize;
    
  public KnownForInVariableAddress () {
    super();
    address = null;
    elemSize = 0;
  }

  public KnownForInVariableAddress (int size, int level, int displacement, int elemS) {
    super(size);
    address = new ObjectAddress(level, displacement);
    elemSize = elemS;
  }

  public ObjectAddress address;

  
}

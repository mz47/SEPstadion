
package dataStorage;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Named(value = "stadium")
@Dependent
public class stadium implements Serializable {
    
    private String id;
    private String name;
    private ArrayList<block> blocks;
    
    public stadium() {
        blocks = new ArrayList<>();
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public ArrayList<block> getBlocks() {
        return blocks;
    }

    public void setBlocks(ArrayList<block> blocks) {
        this.blocks = blocks;
    }
    
    public void addBlock(block block)
    {
        if(block != null)
        {
            this.blocks.add(block);
        }
    }
    
    public block getBlock(int index)
    {
        if(blocks.size() > 0)
        {
            return blocks.get(index);
        }
        else
        {
            return null;
        }
    }
    
    public block getBlock(String pos)
    {
        block block = new block();
        for(block b : blocks)
        {
            if(b.getPos().equals(pos))
            {
                block = b;
            }
        }
        return block;
    }
}

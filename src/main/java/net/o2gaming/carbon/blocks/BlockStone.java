package net.o2gaming.carbon.blocks;

import java.util.Random;
import net.minecraft.server.v1_7_R4.Block;
import net.minecraft.server.v1_7_R4.Blocks;
import net.minecraft.server.v1_7_R4.CreativeModeTab;
import net.minecraft.server.v1_7_R4.Item;
import net.minecraft.server.v1_7_R4.Material;


public class BlockStone extends Block {
    
    public static final String[] names = {"stone", "andesite", "smooth_andesite", "diorite", "smooth_diorite", "granite", "smooth_granite"};
  
    public BlockStone() {
        super(Material.STONE);
        a(CreativeModeTab.b);
        //Sets hardness of block
        c(1.5f);
        //Sets blast
        b(10.0F);
    }

    @Override
    public Item getDropType(int i, Random random, int j) {
        if (i == 0) {
            return Item.getItemOf(Blocks.COBBLESTONE);
        } else {
            return Item.getItemOf(this);
        }
    }

    @Override
    public int getDropData(int i) {
        return i;
    }

}
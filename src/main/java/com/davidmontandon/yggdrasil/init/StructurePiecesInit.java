package com.davidmontandon.yggdrasil.init;

import com.davidmontandon.yggdrasil.Yggdrasil;
import com.davidmontandon.yggdrasil.world.feature.structure.piece.YggdrasilTreePieces;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;

public class StructurePiecesInit {


    public static final IStructurePieceType YGGDRASIL_TREE_PIECES = register("yggdrasil_tree_pieces", YggdrasilTreePieces.Piece::new);
    
    private static IStructurePieceType register(String key, IStructurePieceType type) {
        return Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(Yggdrasil.MOD_ID, key), type);
    }
    	
}

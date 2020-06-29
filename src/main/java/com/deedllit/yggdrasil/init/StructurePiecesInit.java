package com.deedllit.yggdrasil.init;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.world.feature.structure.YggdrasilTreeStructure;
import com.deedllit.yggdrasil.world.feature.structure.piece.YggdrasilTreePieces;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;

public class StructurePiecesInit {


	public static final IStructurePieceType YGGDRASIL_TREE = YggdrasilTreePieces.YggdrasilTreePiece::new;
    
	public static void registerPieces() {
		YggdrasilTreePieces.register();
		
		register(YggdrasilTreeStructure.SHORT_NAME, YGGDRASIL_TREE);
		
	}
	
    private static void register(String key, IStructurePieceType type) {
        Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(Yggdrasil.MOD_ID, key), type);
    }
	
}

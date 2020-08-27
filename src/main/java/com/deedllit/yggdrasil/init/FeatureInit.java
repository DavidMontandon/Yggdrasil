package com.deedllit.yggdrasil.init;

import java.util.Locale;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.world.feature.simple.asgard.*;
import com.deedllit.yggdrasil.world.feature.structure.*;
import com.deedllit.yggdrasil.world.feature.structure.midgard.*;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.registries.IForgeRegistry;

public class FeatureInit {

	public static Structure<NoFeatureConfig> RUN_DOWN_HOUSE = new RunDownHouseStructure(NoFeatureConfig::deserialize);
	public static IStructurePieceType RDHP = RunDownHousePieces.Piece::new;

	public static Structure<NoFeatureConfig> MANGROVE_WITCH = new MangroveWitchHutStructure(NoFeatureConfig::deserialize);
	public static IStructurePieceType MANGROVE_WITCH_PIECES = MangroveWitchHutPieces.Piece::new;

	public static Feature<NoFeatureConfig> ASGARD_GOLD_WELL = new AsgadGoldWeelsFeature(NoFeatureConfig::deserialize) ; 
	public static Feature<NoFeatureConfig> ASGARD_BIFORST = new AsgadBifrostFeature(NoFeatureConfig::deserialize) ; 
	
	
	
	public static void registerFeatures(Register<Feature<?>> event) {
		IForgeRegistry<Feature<?>> registry = event.getRegistry();

		Yggdrasil.register(registry, RUN_DOWN_HOUSE, "run_down_house");
		register(RDHP, "RDHP");
		
		Yggdrasil.register(registry, MANGROVE_WITCH, "mangrove_witch_hut");
		register(MANGROVE_WITCH_PIECES, "mangrove_witch_hut_pieces");

		
	}
	
	static IStructurePieceType register(IStructurePieceType structurePiece, String key) {
		return Registry.register(Registry.STRUCTURE_PIECE, key.toLowerCase(Locale.ROOT), structurePiece);
	}
	
}

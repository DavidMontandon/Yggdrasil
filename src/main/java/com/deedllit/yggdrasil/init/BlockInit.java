package com.deedllit.yggdrasil.init;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.common.block.YggdrasilFlowerBlock;
import com.deedllit.yggdrasil.common.block.YggdrasilPressurePlateBlock;
import com.deedllit.yggdrasil.common.block.YggdrasilWoodButtonBlock;
import com.deedllit.yggdrasil.common.block.midgard.YggdrasilGrass;
import com.deedllit.yggdrasil.common.block.muspelheim.*;
import com.deedllit.yggdrasil.init.objects.blocks.*;
import com.deedllit.yggdrasil.objects.blocks.PedestalItemBlock;
import com.deedllit.yggdrasil.objects.blocks.muspelheim.*;
import com.deedllit.yggdrasil.objects.bushes.muspelheim.* ; 
import com.deedllit.yggdrasil.world.feature.tree.*;

import net.minecraft.block.PressurePlateBlock.Sensitivity;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SandBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TallFlowerBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS,  Yggdrasil.MOD_ID) ; 	

	
	
	/* GLOBAL
	 * 
	 */
	public static final RegistryObject<Block> VANAFREINTINE_BLOCK = BLOCKS.register("vanafreintine_block",
			() -> new Block(Block.Properties.from(Blocks.GOLD_BLOCK)));
	
	public static final RegistryObject<Block> SULFUR_BLOCK = BLOCKS.register("sulfur",
			() -> new Block(Block.Properties.from(Blocks.GRAVEL)));

	public static final RegistryObject<Block> YGGDRASIL_WOOD = BLOCKS.register("yggdrasil_wood",
			() -> new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> YGGDRASIL_PLANKS = BLOCKS.register("yggdrasil_planks",
			() -> new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> RUNE_ORE = BLOCKS.register("rune_ore",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> VANAFREINTINE_ORE = BLOCKS.register("vanafreintine_ore",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.STONE)));
			
	public static final RegistryObject<Block> KIMBERLITE = BLOCKS.register("kimberlite",
			() -> new Block(Block.Properties.from(Blocks.OBSIDIAN)));

	public static final RegistryObject<Block> KIMBERLITE_ORE = BLOCKS.register("kewheatrium_ore",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.STONE)));

	
	/*
	 * SPEICAL BLOCK
	 */
	
	public static final RegistryObject<Block> SPECAL_BLOCK = BLOCKS.register("portal_shirne_block",
			() -> new PortalShirneBlock(Block.Properties.create(Material.IRON)
					.hardnessAndResistance(2.0f, 10.0f)
					.harvestLevel(2)
					.harvestTool(ToolType.PICKAXE)
					.sound(SoundType.GLASS)
					.lightValue(4)
					.slipperiness(1.2f)
					.speedFactor(0.7f)
					.noDrops()));
	
	public static final RegistryObject<Block> PEDESTAL_ITEM = BLOCKS.register("pedestal_item",
			() -> new PedestalItemBlock(Block.Properties.from(Blocks.ANVIL)));

	
	/*
	 * 	YGGDRASIL TREE
	 */
	
	public static final RegistryObject<Block> YGGDRASIL_TREE_LOG = BLOCKS.register("yggdrasil_tree_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));
	
	public static final RegistryObject<Block> YGGDRASIL_TREE_LEAVES = BLOCKS.register("yggdrasil_tree_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));

	/*
	 * MIDGARD
	 */

	//ELM TREE
	
	public static final RegistryObject<Block> ELM_LOG = BLOCKS.register("elm_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));

	public static final RegistryObject<Block> ELM_PLANKS = BLOCKS.register("elm_planks",
			() -> new Block(Block.Properties.from(Blocks.DARK_OAK_PLANKS)));

	public static final RegistryObject<Block> ELM_STAIRS = BLOCKS.register("elm_stairs",
			() -> new StairsBlock(() -> BlockInit.ELM_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> ELM_FENCE = BLOCKS.register("elm_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> ELM_BUTTON = BLOCKS.register("elm_button",
			() -> new YggdrasilWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> ELM_PRESSURE_PLATE = BLOCKS.register("elm_pressure_plate",
			() -> new YggdrasilPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
		
	//ASH TREE

	public static final RegistryObject<Block> ASH_LOG = BLOCKS.register("ash_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));
	
	public static final RegistryObject<Block> ASH_PLANKS = BLOCKS.register("ash_planks",
			() -> new Block(Block.Properties.from(Blocks.DARK_OAK_PLANKS)));

	public static final RegistryObject<Block> ASH_STAIRS = BLOCKS.register("ash_stairs",
			() -> new StairsBlock(() -> BlockInit.ASH_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));

	
	//COCO NUT
	
	public static final RegistryObject<Block> COCO_NUT_PLANKS = BLOCKS.register("coco_nut_planks",
			() -> new Block(Block.Properties.from(Blocks.DARK_OAK_PLANKS)));

	
	public static final RegistryObject<Block> COCO_NUT_STAIRS = BLOCKS.register("coco_nut_stairs",
			() -> new StairsBlock(() -> BlockInit.COCO_NUT_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	

	public static final RegistryObject<Block> PALM_LOG = BLOCKS.register("palm_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));

	public static final RegistryObject<Block> GREEN_PALM_LOG = BLOCKS.register("green_palm_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));

	public static final RegistryObject<Block> PALM_LEAVES = BLOCKS.register("palm_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));

	public static final RegistryObject<Block> IRON_WOOD_LOG = BLOCKS.register("iron_wood_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));

	public static final RegistryObject<Block> IRON_WOOD_LEAVES = BLOCKS.register("iron_wood_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));

	public static final RegistryObject<Block> IRON_WOOD_SAPLING = BLOCKS.register("iron_wood_sapling",
			() -> new IronWoodSaplingBlock(() -> new IronWoodTree(), Block.Properties.from(Blocks.OAK_SAPLING)));

	public static final RegistryObject<Block> HIBICUS_TREE_LEAVES = BLOCKS.register("hibiscus_tree_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	
	public static final RegistryObject<Block> MIDGARD_MANGROVE_LOG = BLOCKS.register("midgard_mangrove_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));
	
	public static final RegistryObject<Block> MIDGARD_MANGROVE_PLANKS = BLOCKS.register("midgard_mangrove_planks",
			() -> new Block(Block.Properties.from(Blocks.DARK_OAK_PLANKS)));

	public static final RegistryObject<Block> MIDGARD_MANGROVE_LEAVES = BLOCKS.register("midgard_mangrove_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));

	public static final RegistryObject<Block> MIDGARD_BLUE_POMELIA_BUSH = BLOCKS.register("midgard_blue_pomelia_bush", 
			() -> new TallFlowerBlock(Block.Properties.from(Blocks.ROSE_BUSH)));

	public static final RegistryObject<Block> MIDGARD_TEAL_POMELIA_BUSH = BLOCKS.register("midgard_teal_pomelia_bush", 
			() -> new TallFlowerBlock(Block.Properties.from(Blocks.ROSE_BUSH)));

	public static final RegistryObject<Block> MIDGARD_PINK_POMELIA_BUSH = BLOCKS.register("midgard_pink_pomelia_bush", 
			() -> new TallFlowerBlock(Block.Properties.from(Blocks.ROSE_BUSH)));

	public static final RegistryObject<Block> MIDGARD_ORANGE_POMELIA_BUSH = BLOCKS.register("midgard_orange_pomelia_bush", 
			() -> new TallFlowerBlock(Block.Properties.from(Blocks.ROSE_BUSH)));

	public static final RegistryObject<Block> MIDGARD_WHITE_POMELIA_BUSH = BLOCKS.register("midgard_white_pomelia_bush", 
			() -> new TallFlowerBlock(Block.Properties.from(Blocks.ROSE_BUSH)));
	
	public static final RegistryObject<Block> IXIA_VIRIDIFLORA_TEAL_BUSH = BLOCKS.register("ixia_viridiflora_teal_bush", 
			() -> new TallFlowerBlock(Block.Properties.from(Blocks.ROSE_BUSH)));

	public static final RegistryObject<Block> RED_SUNFLOWER = BLOCKS.register("red_sunflower", 
			() -> new TallFlowerBlock(Block.Properties.from(Blocks.SUNFLOWER)));
	
	public static final RegistryObject<Block> PURPLE_SUNFLOWER = BLOCKS.register("purple_sunflower", 
			() -> new TallFlowerBlock(Block.Properties.from(Blocks.SUNFLOWER)));

	public static final RegistryObject<Block> SWEET_PEA = BLOCKS.register("sweet_pea",
			() -> new YggdrasilFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.FIRE_RESISTANCE, 20, Block.Properties.from(Blocks.ALLIUM))) ;

	public static final RegistryObject<Block> CHARDON = BLOCKS.register("chardon",
			() -> new YggdrasilFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.REGENERATION, 1, Block.Properties.from(Blocks.POPPY))) ;
	
	public static final RegistryObject<Block> GUZMANIA_RED = BLOCKS.register("guzmania_red",
			() -> new YggdrasilFlowerBlock(PlantType.Desert, Blocks.SAND, Effects.REGENERATION, 1, Block.Properties.from(Blocks.ALLIUM))) ;

	public static final RegistryObject<Block> GUZMANIA_PINK = BLOCKS.register("guzmania_pink",
			() -> new YggdrasilFlowerBlock(PlantType.Desert, Blocks.SAND, Effects.REGENERATION, 1, Block.Properties.from(Blocks.ALLIUM))) ;
	
	public static final RegistryObject<Block> FISH_HOOK = BLOCKS.register("fish_hook",
			() -> new YggdrasilFlowerBlock(PlantType.Desert, Blocks.SAND, Effects.REGENERATION, 1, Block.Properties.from(Blocks.ALLIUM))) ;
	
	public static final RegistryObject<Block> DESERT_GRASS = BLOCKS.register("desert_grass",
			() -> new YggdrasilGrass(PlantType.Desert, new Block[] {Blocks.SAND, Blocks.RED_SAND} , Block.Properties.from(Blocks.GRASS))) ;

	public static final RegistryObject<Block> EDELWEISS = BLOCKS.register("edelweiss",
			() -> new YggdrasilFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.REGENERATION, 2, Block.Properties.from(Blocks.POPPY))) ;

	public static final RegistryObject<Block> WHITE_SAND = BLOCKS.register("white_sand", 
			() -> new SandBlock(15527400, Block.Properties.create(Material.SAND, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.SAND)));

	public static final RegistryObject<Block> BLACK_SAND = BLOCKS.register("black_sand", 
			() -> new SandBlock(1710618, Block.Properties.create(Material.SAND, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.SAND)));

	public static final RegistryObject<Block> TEAK_WOOD_LOG = BLOCKS.register("teak_wood_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));
	
	/*
	 *  MUSPELHEIM
	 */		
	
	public static final RegistryObject<Block> MUSPELHEIM_FIRE_POPPY = BLOCKS.register("muspelheim_fire_poppy",
			() -> new FlowerBlock(Effects.FIRE_RESISTANCE, 20, Block.Properties.from(Blocks.ALLIUM))) ;

	public static final RegistryObject<Block> MUSPELHEIM_FARMLAND_BLOCK = BLOCKS.register("muspelheim_farmland",
			() -> new MuspelheimFarmlandBlock(Block.Properties.from(Blocks.FARMLAND))) ;
	
	public static final RegistryObject<Block> MUSPELHEIM_HOT_ROCK = BLOCKS.register("muspelheim_hot_rock",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F).sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> MUSPELHEIM_COLD_ROCK = BLOCKS.register("muspelheim_cold_rock",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> MUSPELHEIM_STONE = BLOCKS.register("muspelheim_stone",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> MUSPELHEIM_ASH = BLOCKS.register("muspelheim_ash",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> MUSPELHEIM_GRASS = BLOCKS.register("muspelheim_grass",
			() -> new MuspelheimGrass(Block.Properties.from(Blocks.GRASS_BLOCK)));
			
	public static final RegistryObject<Block> MUSPELHEIM_EPLUPHIFER_LOG = BLOCKS.register("muspelheim_epluphifer_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));

	public static final RegistryObject<Block> MUSPELHEIM_EPLUPHIFER_SICK_LOG = BLOCKS.register("muspelheim_epluphifer_sick_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));

	public static final RegistryObject<Block> MUSPELHEIM_EPLUPHIFER_PLANKS = BLOCKS.register("muspelheim_epluphifer_planks",
			() -> new Block(Block.Properties.from(Blocks.DARK_OAK_PLANKS)));
	
	public static final RegistryObject<Block> MUSPELHEIM_EPLUPHIFER_SAPLING = BLOCKS.register("muspelheim_epluphifer_sapling",
			() -> new YggdrasilSaplingBlock(() -> new EpluphiferTree(), Block.Properties.from(Blocks.OAK_SAPLING)));
		
	public static final RegistryObject<Block> MUSPELHEIM_EPLUPHIFER_LEAVES = BLOCKS.register("muspelheim_epluphifer_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));

	public static final RegistryObject<Block> MUSPELHEIM_IKADAMIA_CROP = BLOCKS.register("muspelheim_ikadamia",
			() -> new  MuspelheimIkadamiaCropBlock(Block.Properties.from(Blocks.WHEAT)));
	
	public static final RegistryObject<Block> MUSPELHEIM_ASH_CARAMBOLA_BUSH = BLOCKS.register("muspelheim_ash_carambola_bush",
			() -> new MuspelheimAshCarambola(Block.Properties.from(Blocks.SWEET_BERRY_BUSH))) ; 
	
	public static final RegistryObject<Block> MUSPELHEIM_DRAGON_GRASS = BLOCKS.register("muspelheim_dragon_grass",
			() -> new MuspelheimDragonGrassBlock(Block.Properties.from(Blocks.TALL_GRASS))) ; 
		
	public static final RegistryObject<Block> MUSPELHEIM_SLIM_GRASS = BLOCKS.register("muspelheim_slim_grass",
			() -> new MuspelheimSlimGrass(Block.Properties.from(Blocks.TALL_GRASS))) ; 

	/*
	 * SVARTALVHEIM
	 */
	
	public static final RegistryObject<Block> SVARTALVHEIM_STONE = BLOCKS.register("svartalvheim_stone",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F).sound(SoundType.STONE)));

	
}



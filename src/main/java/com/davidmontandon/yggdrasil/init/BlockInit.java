package com.davidmontandon.yggdrasil.init;

import com.davidmontandon.yggdrasil.Yggdrasil;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockInit {

	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS,  Yggdrasil.MOD_ID) ; 	

	public static final RegistryObject<Block> YGGDRASIL_WOOD = BLOCKS.register("yggdrasil_wood",
			() -> new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> YGGDRASIL_PLANKS = BLOCKS.register("yggdrasil_planks",
			() -> new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> RUNE_ORE = BLOCKS.register("rune_ore",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> VANAFREINTINE_ORE = BLOCKS.register("vanafreintine_ore",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> MUSPELHEIM_HOT_ROCK = BLOCKS.register("muspelheim_hot_rock",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F).sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> MUSPELHEIM_COLD_ROCK = BLOCKS.register("muspelheim_cold_rock",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> MUSPELHEIM_STONE = BLOCKS.register("muspelheim_stone",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F).sound(SoundType.STONE)));

}

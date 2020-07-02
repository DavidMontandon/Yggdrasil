package com.deedllit.yggdrasil.common.world;

import java.util.List;
import java.util.function.Supplier;

//import com.deedllit.yggdrasil.world.gen.CavernDimensionGenSettings;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.profiler.IProfiler;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.tags.NetworkTagManager;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.ITickList;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.AbstractChunkProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.storage.ISpawnWorldInfo;
import net.minecraft.world.storage.MapData;

public class YggdrasilDimension extends World {


	protected YggdrasilDimension(ISpawnWorldInfo p_i231617_1_, RegistryKey<World> p_i231617_2_,
			RegistryKey<DimensionType> p_i231617_3_, DimensionType p_i231617_4_, Supplier<IProfiler> p_i231617_5_,
			boolean p_i231617_6_, boolean p_i231617_7_, long p_i231617_8_) {
		super(p_i231617_1_, p_i231617_2_, p_i231617_3_, p_i231617_4_, p_i231617_5_, p_i231617_6_, p_i231617_7_, p_i231617_8_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ITickList<Block> getPendingBlockTicks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITickList<Fluid> getPendingFluidTicks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractChunkProvider getChunkProvider() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void playEvent(PlayerEntity player, int type, BlockPos pos, int data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<? extends PlayerEntity> getPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Biome getNoiseBiomeRaw(int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float func_230487_a_(Direction p_230487_1_, boolean p_230487_2_) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void notifyBlockUpdate(BlockPos pos, BlockState oldState, BlockState newState, int flags) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playSound(PlayerEntity player, double x, double y, double z, SoundEvent soundIn, SoundCategory category,
			float volume, float pitch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playMovingSound(PlayerEntity playerIn, Entity entityIn, SoundEvent eventIn, SoundCategory categoryIn,
			float volume, float pitch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Entity getEntityByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MapData getMapData(String mapName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerMapData(MapData mapDataIn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getNextMapId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void sendBlockBreakProgress(int breakerId, BlockPos pos, int progress) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Scoreboard getScoreboard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecipeManager getRecipeManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NetworkTagManager getTags() {
		// TODO Auto-generated method stub
		return null;
	}

}

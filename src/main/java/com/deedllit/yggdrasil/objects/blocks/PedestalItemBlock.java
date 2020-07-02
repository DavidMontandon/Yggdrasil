package com.deedllit.yggdrasil.objects.blocks;

import java.util.stream.Stream;

import com.deedllit.yggdrasil.init.YggdrasilTileEntityTypes;
import com.deedllit.yggdrasil.objects.tileentities.PedestalItemTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class PedestalItemBlock extends Block {

	public PedestalItemBlock(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

}
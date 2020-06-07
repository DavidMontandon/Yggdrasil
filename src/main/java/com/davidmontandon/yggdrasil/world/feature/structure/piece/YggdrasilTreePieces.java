package com.davidmontandon.yggdrasil.world.feature.structure.piece;

import java.util.Random;

import com.davidmontandon.yggdrasil.Yggdrasil;
import com.davidmontandon.yggdrasil.init.StructurePiecesInit;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.TemplateStructurePiece;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.List;

public class YggdrasilTreePieces {
    private static final ResourceLocation LOCATION = new ResourceLocation(Yggdrasil.MOD_ID, "treetest");

    public static void addTowerPieces(TemplateManager templateManager, BlockPos origin, Rotation rotation, List<StructurePiece> pieces) {
    	pieces.add(new YggdrasilTreePieces.Piece(templateManager, LOCATION, origin, rotation));
    }
    
    public static class Piece extends TemplateStructurePiece {
        private final ResourceLocation templateLocation;
        private final Rotation rotation;
    	
        public Piece(TemplateManager templateManager, ResourceLocation templateLocation, BlockPos position, Rotation rotation) {
            super(StructurePiecesInit.YGGDRASIL_TREE_PIECES, 0);
            this.templateLocation = templateLocation;
            this.templatePosition = position;
            this.rotation = rotation;
            this.setup(templateManager);
        }
    	
    	
        public Piece(TemplateManager templateManager, CompoundNBT compound) {
            super(StructurePiecesInit.YGGDRASIL_TREE_PIECES, compound);
            this.templateLocation = new ResourceLocation(compound.getString("Template"));
            this.rotation = Rotation.valueOf(compound.getString("Rot"));
            this.setup(templateManager);
        }

        private void setup(TemplateManager templateManager) {
            Template template = templateManager.getTemplateDefaulted(this.templateLocation);
            PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation).setMirror(Mirror.NONE).addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK);
            this.setup(template, this.templatePosition, placementsettings);
        }
        
        @Override
        protected void readAdditional(CompoundNBT compound) {
            super.readAdditional(compound);
            compound.putString("Template", this.templateLocation.toString());
            compound.putString("Rot", this.rotation.name());
        }
        
        @Override
        protected void handleDataMarker(String function, BlockPos pos, IWorld worldIn, Random rand, MutableBoundingBox sbb) {

        }
        
        @Override
        public boolean create(IWorld world, ChunkGenerator<?> p_225577_2_, Random random, MutableBoundingBox bounds, ChunkPos chunkPos) {
            PlacementSettings settings = new PlacementSettings()
                    .setRotation(this.rotation)
                    .setMirror(Mirror.NONE)
                    .addProcessor(BlockIgnoreStructureProcessor.AIR_AND_STRUCTURE_BLOCK);

            BlockPos origin = this.templatePosition.add(Template.transformedBlockPos(settings, new BlockPos(5, 0, 3)));
            int height = world.getHeight(Heightmap.Type.WORLD_SURFACE_WG, origin.getX(), origin.getZ());

            BlockPos templateOrigin = this.templatePosition;

            this.templatePosition = this.templatePosition.add(0, height - 90 - 1, 0);
            boolean result = super.create(world, p_225577_2_, random, bounds, chunkPos);
            this.templatePosition = templateOrigin;

            return result;
        }
        
    }
    
}

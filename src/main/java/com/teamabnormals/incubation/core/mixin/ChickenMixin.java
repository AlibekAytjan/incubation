package com.teamabnormals.incubation.core.mixin;

import com.teamabnormals.incubation.core.api.EggLayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Random;

@Mixin(Chicken.class)
public abstract class ChickenMixin extends Animal implements EggLayer {

	protected ChickenMixin(EntityType<? extends Animal> type, Level worldIn) {
		super(type, worldIn);
	}

	@Shadow
	public int eggTime;

	@Shadow
	public boolean isChickenJockey;

	@Override
	public int getEggTimer() {
		return this.eggTime;
	}

	@Override
	public void setEggTimer(int time) {
		this.eggTime = time;
	}

	@Override
	public boolean isBirdJockey() {
		return this.isChickenJockey;
	}

	@Override
	public Item getEggItem() {
		return Items.EGG;
	}

	@Override
	public int getNextEggTime(Random rand) {
		return rand.nextInt(6000) + 6000;
	}

	@Override
	public SoundEvent getEggLayingSound() {
		return SoundEvents.CHICKEN_EGG;
	}
}
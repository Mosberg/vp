package dk.mosberg.client.model;

import dk.mosberg.entity.SwordVillagerEntity;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class SwordVillagerEntityModel extends EntityModel<SwordVillagerEntity> implements HeadedModel {

  private final ModelPart root;
  private final ModelPart head;
  private final ModelPart body;
  private final ModelPart rightArm;
  private final ModelPart leftArm;
  private final ModelPart rightLeg;
  private final ModelPart leftLeg;

  public SwordVillagerEntityModel(ModelPart root) {
    this.root = root;
    this.head = root.getChild("head");
    this.body = root.getChild("body");
    this.rightArm = root.getChild("right_arm");
    this.leftArm = root.getChild("left_arm");
    this.rightLeg = root.getChild("right_leg");
    this.leftLeg = root.getChild("left_leg");
  }

  public static TexturedModelData getTexturedModelData() {
    ModelData data = new ModelData();
    ModelPartData root = data.getRoot();

    root.addChild("head",
        ModelPartBuilder.create()
            .uv(0, 0).cuboid(-4, -10, -4, 8, 10, 8),
        ModelTransform.NONE);

    root.addChild("body",
        ModelPartBuilder.create()
            .uv(16, 20).cuboid(-4, 0, -3, 8, 12, 6),
        ModelTransform.NONE);

    root.addChild("right_arm",
        ModelPartBuilder.create()
            .uv(44, 22).cuboid(-3, -2, -2, 4, 12, 4),
        ModelTransform.pivot(-5, 2, 0));

    root.addChild("left_arm",
        ModelPartBuilder.create()
            .uv(44, 22).mirrored().cuboid(-1, -2, -2, 4, 12, 4),
        ModelTransform.pivot(5, 2, 0));

    root.addChild("right_leg",
        ModelPartBuilder.create()
            .uv(0, 22).cuboid(-2, 0, -2, 4, 12, 4),
        ModelTransform.pivot(-2, 12, 0));

    root.addChild("left_leg",
        ModelPartBuilder.create()
            .uv(0, 22).mirrored().cuboid(-2, 0, -2, 4, 12, 4),
        ModelTransform.pivot(2, 12, 0));

    return TexturedModelData.of(data, 64, 64);
  }

  @Override
  public void setAngles(SwordVillagerEntity entity, float limbSwing, float limbSwingAmount,
      float ageInTicks, float netHeadYaw, float headPitch) {

    head.yaw = netHeadYaw * 0.017453292F;
    head.pitch = headPitch * 0.017453292F;

    rightLeg.pitch = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    leftLeg.pitch = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;

    if (entity.handSwinging) {
      float swing = entity.getHandSwingProgress(ageInTicks);
      float angle = MathHelper.sin(swing * (float) Math.PI);
      rightArm.pitch = -1.5F + angle * 1.2F;
      rightArm.yaw = 0.0F;
    } else {
      rightArm.pitch = -0.2F;
      leftArm.pitch = -0.2F;
    }
  }

  @Override
  public ModelPart getHead() {
    return head;
  }

  @Override
  public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay,
      float red, float green, float blue, float alpha) {
    root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
  }
}

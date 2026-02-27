package dk.mosberg.client.render.entity.model;

import dk.mosberg.client.render.entity.state.SwordVillagerEntityRenderState;
import dk.mosberg.entity.SwordVillagerEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.model.ModelWithArms;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class SwordVillagerEntityModel extends EntityModel<SwordVillagerEntityRenderState>
    implements ModelWithArms {
  public ModelPart getRightArm() {
    return this.rightArm;
  }

  public ModelPart getLeftArm() {
    return this.leftArm;
  }

  private final ModelPart root;
  private final ModelPart head;
  private final ModelPart body;
  private final ModelPart rightArm;
  private final ModelPart leftArm;
  private final ModelPart rightLeg;
  private final ModelPart leftLeg;

  public SwordVillagerEntityModel(ModelPart root) {
    super(root);
    this.root = root;
    this.head = root.getChild(EntityModelPartNames.HEAD);
    this.body = root.getChild(EntityModelPartNames.BODY);
    this.rightArm = root.getChild(EntityModelPartNames.RIGHT_ARM);
    this.leftArm = root.getChild(EntityModelPartNames.LEFT_ARM);
    this.rightLeg = root.getChild(EntityModelPartNames.RIGHT_LEG);
    this.leftLeg = root.getChild(EntityModelPartNames.LEFT_LEG);
  }

  public static TexturedModelData getTexturedModelData() {
    ModelData modelData = new ModelData();
    ModelPartData modelPartData = modelData.getRoot();

    // Head
    ModelPartData headData = modelPartData.addChild(
        EntityModelPartNames.HEAD,
        ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F),
        ModelTransform.NONE);

    // Body
    modelPartData.addChild(
        EntityModelPartNames.BODY,
        ModelPartBuilder.create().uv(16, 20).cuboid(-4.0F, 0.0F, -3.0F, 8.0F, 12.0F, 6.0F),
        ModelTransform.NONE);

    // Right Arm
    modelPartData.addChild(
        EntityModelPartNames.RIGHT_ARM,
        ModelPartBuilder.create().uv(44, 22).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F),
        ModelTransform.of(-5.0F, 2.0F, 0.0F, -0.75F, 0.0F, 0.0F));

    // Left Arm
    modelPartData.addChild(
        EntityModelPartNames.LEFT_ARM,
        ModelPartBuilder.create().uv(44, 22).mirrored().cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F),
        ModelTransform.of(5.0F, 2.0F, 0.0F, 0.75F, 0.0F, 0.0F));

    // Right Leg
    modelPartData.addChild(
        EntityModelPartNames.RIGHT_LEG,
        ModelPartBuilder.create().uv(0, 22).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F),
        ModelTransform.of(-2.0F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F));

    // Left Leg
    modelPartData.addChild(
        EntityModelPartNames.LEFT_LEG,
        ModelPartBuilder.create().uv(0, 22).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F),
        ModelTransform.of(2.0F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F));

    return TexturedModelData.of(modelData, 64, 64);
  }

  public void setAngles(SwordVillagerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
      float headYaw, float headPitch) {
    this.getPart().traverse().forEach(ModelPart::resetTransform);

    this.head.yaw = headYaw * (0.017453292F);
    this.head.pitch = headPitch * (0.017453292F);

    this.rightLeg.pitch = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    this.leftLeg.pitch = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;

    if (entity.isSwingingHand()) {
      float swingProgress = entity.getHandSwingProgress(ageInTicks);
      float swingAngle = MathHelper.sin(swingProgress * (float) Math.PI);
      this.rightArm.pitch = MathHelper.lerp(swingProgress, -0.2F, -1.5F + swingAngle * 1.2F);
      this.rightArm.yaw = 0.0F;
    } else {
      this.rightArm.pitch = -0.2F;
      this.leftArm.pitch = -0.2F;
    }
  }

  protected ModelPart getPart() {
    return this.root;
  }

  @Override
  public void setArmAngle(net.minecraft.client.render.entity.state.EntityRenderState state, net.minecraft.util.Arm arm,
      net.minecraft.client.util.math.MatrixStack matrices) {
    ModelPart part = arm == net.minecraft.util.Arm.RIGHT ? this.rightArm : this.leftArm;
    part.applyTransform(matrices);
  }
}

package dk.mosberg.profession;

public enum SwordVillagerProfession {
  NONE, GUARD, CAPTAIN, BLADEMASTER;

  public static SwordVillagerProfession fromId(int id) {
    if (id < 0 || id >= values().length)
      return NONE;
    return values()[id];
  }
}
package dk.mosberg.client.hud;

public record Hud(String displayText, String fontName, String perm,
    boolean disabledWhilstInWater, boolean enabledByDefault,
    boolean enableInSpectatorMode) {
  public String getDisplayText() {
    return displayText;
  }

  public String getFont() {
    return fontName;
  }

  public String getPerm() {
    return perm;
  }

  public boolean isEnabledByDefault() {
    return enabledByDefault;
  }

  public boolean isDisabledWhilstInWater() {
    return disabledWhilstInWater;
  }

  public boolean enableInSpectatorMode() {
    return enableInSpectatorMode;
  }
}
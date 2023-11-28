package com.aks.stick_hero_ap;

public interface SaveData {
    void addSaveGame(int serial, Player player);
    void removeSaveGame(int serial);
    Player getSaveGame(int serial);
}

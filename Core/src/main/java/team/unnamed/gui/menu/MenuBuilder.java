package team.unnamed.gui.menu;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import team.unnamed.gui.button.SimpleButton;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MenuBuilder {

    private final String title;
    private int rows;
    private Map<Integer, ItemStack> items;
    private Set<SimpleButton> buttons;

    public MenuBuilder(String title) {
        this(title, 6);
    }

    public MenuBuilder(String title, int rows) {
        this.title = title;
        this.rows = rows;

        this.items = new HashMap<>();
        this.buttons = new HashSet<>();
    }

    public MenuBuilder rows(int rows) {
        this.rows = rows;

        return this;
    }

    public MenuBuilder items(Map<Integer, ItemStack> items) {
        this.items = items;

        return this;
    }

    public MenuBuilder addItem(Integer slot, ItemStack item) {
        this.items.putIfAbsent(slot, item);

        return this;
    }

    public MenuBuilder buttons(Set<SimpleButton> buttons) {
        this.buttons = buttons;

        return this;
    }

    public MenuBuilder addButton(SimpleButton button) {
        this.buttons.add(button);

        return this;
    }

    public String getTitle() {
        return title;
    }

    public Set<SimpleButton> getButtons() {
        return buttons;
    }

    public int getRows() {
        return rows;
    }

    public Map<Integer, ItemStack> getItems() {
        return items;
    }

    public Inventory build() {
        return new MenuHolder(this).getInventory();
    }

}
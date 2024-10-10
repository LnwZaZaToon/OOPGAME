/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package games;

public class Player {

    String name;
    String Role;

    public Player() {
    }

    public Player(String name, String Role) {
        this.name = name;
        this.Role = Role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return Role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

}


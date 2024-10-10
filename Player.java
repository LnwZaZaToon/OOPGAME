/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package games;

public class Player {

    private String name;
    private String Role;

    public Player() {
    }
    public Player(String name) {
        this.name = name;
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


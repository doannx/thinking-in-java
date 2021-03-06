/**
 * Band.java This is an implementation of SocialEntity.
 * 
 * @version %I%, %G%
 * 
 * @author Kim Nguyen
 */

package kim.nguyen.projects;

import java.util.Arrays;

public class Band implements SocialEntity {

    /* Keeps tract of the number of bands created */
    private static long countBand;

    private long id = 0;
    private String name;
    private Person[] fans;
    private Person[] members;
    private String description;
    private String location;

    // TODO: this field is redundant because you can get it from [fans.length]
    // and this field is not mentioned by G requirement
    /* The current number of fans who follow the band */
    private int numFans = 0;

    // TODO: Similar to the above issue
    /* The current number of members who join the band */
    private int numMembers = 0;

    Band(String name, String description, String location) {
        id = countBand;
        countBand++;
        this.name = name;
        this.description = description;
        this.location = location;
        // TODO: because the value of [numMembers] is always 0 in constructor
        // so you can consider to initialize this field inline at its declaration statement, as below:
        // private Person[] fans = {};
        // then you can remove these LOCs
        members = new Person[numMembers];
        fans = new Person[numFans];
    }

    // TODO: getID(): wrong of function name (can use Source > Generate Getters/Setters)
    public long getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // TODO: Method description [Returns the current number of people who follow the band] 
    // is not matched with method execution [return an array]
    /**
     * Returns the current number of people who follow the band
     * 
     * @return the array of fan members
     */
    public Person[] getFans() {
        return Arrays.copyOf(fans, numFans);
    }

    /**
     * Adds the new fan only if the fan is not yet in the list of fans
     * 
     * @param fans
     *            the new fan
     */
    public void addFans(Person fan) {
        SocialEntityComparator comparator = new SocialEntityComparator();
        Arrays.sort(fans, comparator);
        if (Arrays.binarySearch(fans, fan, comparator) != 0) {
            fans = Utils.resizeArray(fans);
            fans = Utils.addElement(fans, fan, numFans);
            numFans++;
        }

    }

    /**
     * Adds the new member only if the member is not yet in the list of members
     * 
     * @param member
     *            the new member
     */
    public void addMember(Person member) {
        SocialEntityComparator comparator = new SocialEntityComparator();
        Arrays.sort(members, comparator);
        if (Arrays.binarySearch(members, member, comparator) != 0) {
            members = Utils.resizeArray(members);
            members = Utils.addElement(members, member, numMembers);
            numMembers++;
        }
    }

    /**
     * Returns the number of members who are currently in the members list
     * 
     * @return the array of member list
     */
    public Person[] getMembers() {
        return Arrays.copyOf(members, numMembers);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

package bdd;

/**
 * describe("A suite is just a function", function() {
 *      it("and so is a spec", function() {
 *      var a = true; expect(a).toBe(true);
 *      });
 * });
 */
public class Description {
    private String name ;

    public Description(String name) {
        this.name = name;
    }

    public void describe(String name, Suite behavior){
        Description description = new Description(name);
        behavior.specifySuite(description);
    }
}

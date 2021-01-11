/**
 * Philipp Fößl 11845350
 */
package at.aau.ue3.bsp2;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RelationCheckerTest {
    //TODO fill tests

    @Test
    public void StatementCoverage1(){
        assertEquals(0,RelationChecker.checkRelation(0,0));
    }

    @Test
    public void StatementCoverage2(){
        assertEquals(22,RelationChecker.checkRelation(10,17));
    }

    @Test
    public void BranchCoverage1(){
        assertEquals(0,RelationChecker.checkRelation(0,0));
    }

    @Test
    public void BranchCoverage2(){
        assertEquals(22,RelationChecker.checkRelation(10,17));
    }

    @Test
    public void PathCoverage1(){
        assertEquals(12,RelationChecker.checkRelation(3,6));
    }

    @Test
    public void PathCoverage2(){
        assertEquals(22,RelationChecker.checkRelation(10,17));
    }

    @Test
    public void PathCoverage3(){
        assertEquals(0,RelationChecker.checkRelation(0,0));
    }

    @Test(expected = ArithmeticException.class)
    public void PathCoverage4(){
        assertEquals(25,RelationChecker.checkRelation(17,10));
    }
}

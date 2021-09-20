package edXAlgorithmicDesignAndTechniques.GreedyAlgorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CoveringSegmentsTest {

    CoveringSegments coverSegments;
    @BeforeEach
    public void setUp() {coverSegments = new CoveringSegments(); }

    @Test
    void testSample1OptimalPoints() {
        int numSegments = 3;
        CoveringSegments.Segment segment1 = new CoveringSegments.Segment(1, 3);
        CoveringSegments.Segment segment2 = new CoveringSegments.Segment(2, 5);
        CoveringSegments.Segment segment3 = new CoveringSegments.Segment(3, 6);
        CoveringSegments.Segment[] segments = new CoveringSegments.Segment[numSegments];
        segments[0] = segment1;
        segments[1] = segment2;
        segments[2] = segment3;
        int[] expectedPoints = {3};
        int expectedLength = 1;
        int[] resultPoints = coverSegments.optimalPoints(segments);
        int resultLength = resultPoints.length;
        Assertions.assertNotNull(resultPoints);
        Assertions.assertEquals(expectedLength, resultLength);
        for (int i = 0; i < expectedPoints.length; i++) {
            Assertions.assertEquals(expectedPoints[i], resultPoints[i]);
        }
    }

    @Test
    void testSample2OptimalPoints() {
        int numSegments = 4;
        CoveringSegments.Segment segment1 = new CoveringSegments.Segment(4, 7);
        CoveringSegments.Segment segment2 = new CoveringSegments.Segment(1, 3);
        CoveringSegments.Segment segment3 = new CoveringSegments.Segment(2, 5);
        CoveringSegments.Segment segment4 = new CoveringSegments.Segment(5, 6);
        CoveringSegments.Segment[] segments = new CoveringSegments.Segment[numSegments];
        segments[0] = segment1;
        segments[1] = segment2;
        segments[2] = segment3;
        segments[3] = segment4;
        int[] expectedPoints = {3, 6};
        int expectedLength = 2;
        int[] resultPoints = coverSegments.optimalPoints(segments);
        int resultLength = resultPoints.length;
        Assertions.assertNotNull(resultPoints);
        Assertions.assertEquals(expectedLength, resultLength);
        for (int i = 0; i < expectedPoints.length; i++) {
            Assertions.assertEquals(expectedPoints[i], resultPoints[i]);
        }
    }
}
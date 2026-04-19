package com.jah.lsp.refactored;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LspRefactoredTest {

    private final BirdController controller = new BirdController();

    @Test
    void eagle_shouldFlyWithoutException() {
        Eagle eagle = new Eagle();
        assertDoesNotThrow(() -> controller.makeBirdFly(eagle));
    }

    @Test
    void eagle_shouldEatWithoutException() {
        Eagle eagle = new Eagle();
        assertDoesNotThrow(() -> controller.feedBird(eagle));
    }

    @Test
    void penguin_shouldEatWithoutException() {
        Penguin penguin = new Penguin();
        
        assertDoesNotThrow(() -> controller.feedBird(penguin));
    }

    @Test
    void penguin_isABird_butNotAFlyingBird() {
        Penguin penguin = new Penguin();

        assertInstanceOf(Bird.class, penguin);
        assertFalse(penguin instanceof FlyingBird,
            "Penguin must NOT implement FlyingBird — it cannot fly");
    }

    @Test
    void eagle_isBothBirdAndFlyingBird() {
        Eagle eagle = new Eagle();

        assertInstanceOf(Bird.class, eagle);
        assertInstanceOf(FlyingBird.class, eagle);
    }

    @Test
    void allBirds_shouldBeSubstitutableForBird() {
        
        Bird[] birds = { new Eagle(), new Penguin() };
        for (Bird b : birds) {
            assertDoesNotThrow(() -> controller.feedBird(b));
        }
    }
}

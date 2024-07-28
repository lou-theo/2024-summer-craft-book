import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import password.PasswordValidator;

import static org.assertj.core.api.Assertions.assertThat;

class PasswordValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {
        "Azerty1234*",
        "Aa1.*#@$%&",
    })
    void is_valid(String passwordToTest) {
        boolean result = new PasswordValidator().valid(passwordToTest);
        assertThat(result).isEqualTo(true);
    }

    @Nested
    class ShouldFail {
        @Test
        void not_empty() {
            boolean result = new PasswordValidator().valid("");
            assertThat(result).isEqualTo(false);
        }

        @Test
        void not_contains_capital_letter() {
            boolean result = new PasswordValidator().valid("a");
            assertThat(result).isEqualTo(false);
        }

        @Test
        void not_contains_lowercase_letter() {
            boolean result = new PasswordValidator().valid("A");
            assertThat(result).isEqualTo(false);
        }

        @Test
        void not_contains_digit() {
            boolean result = new PasswordValidator().valid("Aa");
            assertThat(result).isEqualTo(false);
        }

        @Test
        void not_contains_special_character() {
            boolean result = new PasswordValidator().valid("Aa1");
            assertThat(result).isEqualTo(false);
        }

        @Test
        void not_contains_at_least_8_characters() {
            boolean result = new PasswordValidator().valid("Aa1&");
            assertThat(result).isEqualTo(false);
        }

        @Test
        void contains_invalid_characters() {
            boolean result = new PasswordValidator().valid("Azerty1*!");
            assertThat(result).isEqualTo(false);
        }
    }
}
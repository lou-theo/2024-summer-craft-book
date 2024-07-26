import cache.Cache;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CacheTest {
    @Test
    void cache_insert_non_existing() {
        Cache cache = new Cache();

        int value = cache.getOrInsert("key", 1);
        assertThat(value).isEqualTo(1);
    }

    @Test
    void cache_insert_existing() {
        Cache cache = new Cache();

        cache.getOrInsert("key", 1);
        int value = cache.getOrInsert("key", 5);
        assertThat(value).isEqualTo(1);
    }
}
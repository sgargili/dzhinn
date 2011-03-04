package imf.backend;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Developed by: Andrey Popov
 * Date (time): 04.03.11 (13:20)
 */
@Repository
@Service("testService")
public class TestServiceImpl implements TestService {
    @Override
    @Cacheable("integers")
    public Long getInteger(Integer integer) {
        if (integer <= 1)
            return 1l;
        else
            return integer * getInteger(integer - 1);
    }

    @Override
    @CacheEvict(value = "integers", allEntries = true)
    public void clear() {
    }
}

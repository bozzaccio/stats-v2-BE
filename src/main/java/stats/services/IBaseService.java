package stats.services;

import java.io.IOException;

public interface IBaseService<E, DTO> {

    /**
     * Base method to be implemented with csv data loading.
     * @throws IOException if csv contains formatting errors
     */
    void loadData() throws IOException;

    DTO transformEntity2DTO(E entity);
}

package fiap.challenge.repositories;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import fiap.challenge.models.FilaCheckInOnline;

public interface IFilaCheckInOnlineRepository extends MongoRepository<FilaCheckInOnline, Integer> {

}

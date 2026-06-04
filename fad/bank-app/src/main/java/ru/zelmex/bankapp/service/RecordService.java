package ru.zelmex.bankapp.service;
import ru.zelmex.bankapp.model.Record;
import ru.zelmex.bankapp.repository.RecordDao;
import java.util.List;
public class RecordService {
    private RecordDao recordDao = new RecordDao();
    public RecordService() {
    }
    public List<Record> findAll() {
        return recordDao.findAll();
    }
    public Record findOne(final long id) {
        return recordDao.findOne(id);
    }
    public void save(final Record entity)
    {
        if (entity == null)
            return;
        recordDao.save(entity);
    }
    public void update(final Record entity)
    {
        if (entity == null)
            return;
        recordDao.update(entity);
    }
    public void delete(final Record entity)
    {
        if (entity == null)
            return;
        recordDao.delete(entity);
    }
    public void deleteById(final Long id)
    {
        if (id == null)
            return;
        recordDao.deleteById(id);
    }
}
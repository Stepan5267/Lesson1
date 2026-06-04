package ru.zelmex.bankapp.service;
import ru.zelmex.bankapp.model.ExerciseGroup;
import ru.zelmex.bankapp.repository.ExerciseGroupDao;
import java.util.List;
public class ExerciseGroupService  {
    private ExerciseGroupDao exerciseGroupDao = new ExerciseGroupDao();
    public ExerciseGroupService () {
    }
    public List<ExerciseGroup> findAll() {
        return exerciseGroupDao.findAll();
    }
    public ExerciseGroup findOne(final long id) {
        return exerciseGroupDao.findOne(id);
    }
    public void save(final ExerciseGroup entity)
    {
        if (entity == null)
            return;
        exerciseGroupDao.save(entity);
    }
    public void update(final ExerciseGroup entity)
    {
        if (entity == null)
            return;
        exerciseGroupDao.update(entity);
    }
    public void delete(final ExerciseGroup entity)
    {
        if (entity == null)
            return;
        exerciseGroupDao.delete(entity);
    }
    public void deleteById(final Long id)
    {
        if (id == null)
            return;
        exerciseGroupDao.deleteById(id);
    }
}
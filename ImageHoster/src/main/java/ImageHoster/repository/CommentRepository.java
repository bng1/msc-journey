package ImageHoster.repository;

import ImageHoster.model.Comment;
import ImageHoster.model.Tag;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class CommentRepository {
    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;

    public Comment createComment(Comment comment) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        System.out.println("GOOO create comment commentRepo");
        try {
            transaction.begin();
            em.persist(comment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return comment;
    }

    public Comment findComment(Comment comment) {
        System.out.println("GOOO find comment commentRepo");
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Comment> typedQuery = em.createQuery("SELECT t from Comment t where t.id =:comment.id", Comment.class);
            return typedQuery.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public List<Comment> findCommentsById(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Comment> query = em.createQuery("SELECT p from Comment p", Comment.class);
            List<Comment> resultList = query.getResultList();

            return resultList;
        } catch (NoResultException nre) {
            return null;
        }
    }
}

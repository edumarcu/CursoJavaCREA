package curso.demo22;

import java.sql.Time;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tasks")
public class Task {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
//
//    @Column(name="user_id")
//    private long userId;

    @Column(length=255)
    private String description;

    private double estimation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="completed_at")
    private Date completedAt;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="user_id"
        , referencedColumnName="id"
        )
    private User user;

    public Task() {
//        GregorianCalendar calendar = new GregorianCalendar();
//        calendar.setTime(completedAt);
//        calendar.get(GregorianCalendar.DAY_OF_MONTH);
//        calendar.add(GregorianCalendar.HOUR_OF_DAY, 3);
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        sdf.format(completedAt);
//
//        double hours = estimation.getTime() / 1000.0 / 60.0 /60.0;
    }

    // Getters & Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
//
//    public long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(long userId) {
//        this.userId = userId;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getEstimation() {
        return estimation;
    }

    public void setEstimation(double estimation) {
        this.estimation = estimation;
    }

    public String getEstimationText() {
        int hours = (int) Math.floor(estimation);
        double minutes = estimation - hours;
        int minutesInt = (int) (60 * minutes);
        return String.format("%02d:%02d", hours, minutesInt);
    }

    public void setEstimationText(String text) {
        String hourstxt = text.split(":")[0];
        String minutestxt = text.split(":")[1];

        int hours = Integer.parseInt(hourstxt, 10);
        int minutes = Integer.parseInt(minutestxt, 10);

        this.estimation = hours + (minutes / 60.0);
    }

    public Date getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Date completedAt) {
        this.completedAt = completedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // HashCode & Equals

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Task other = (Task) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    //
    // Active Record
    //

}

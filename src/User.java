public class User {
    private int rank;
    private int progress;

    public User() {
        this.rank = -8;
        this.progress = 0;
    }

    public int getRank() {
        return rank;
    }

    public int getProgress() {
        return progress;
    }


    public String toString() {
        return "User{" + "rank=" + rank + ", progress=" + progress + '}';
    }

    public void incProgress(int activityRank) {
        if (activityRank == 0 || activityRank < -8 || activityRank > 8) {
            throw new IllegalArgumentException("The rank of an activity cannot be less than 8, 0, or greater than 8!");
        } //fixed , error happened because it was worded incorrectly :(

        int d = calculateRankDifference(activityRank);
        int gainedProgress = 0;

        if (d == 0) {
            gainedProgress = 3;
        } else if (d == -1) {
            gainedProgress = 1;
        } else if (d > 0) {
            gainedProgress = 10 * d * d;
        } //forgot extra *d thats why it didntw ork

        updateProgress(gainedProgress);
    }

    private int calculateRankDifference(int activityRank) {
        return rankToIndex(activityRank) - rankToIndex(rank);
    }

    private int rankToIndex(int rank) {
        if (rank > 0) {
            return rank + 7;
        } else {
            return rank + 8;
        }
    }

    private void updateProgress(int gainedProgress) {
        progress += gainedProgress;

        while (progress >= 100 && rank < 8) {
            progress -= 100;

            if (rank == -1) {
                rank = 1;
            } else {
                rank += 1;
            }
        }

        if (rank == 8) {
            progress = 0;
        }
    }
}

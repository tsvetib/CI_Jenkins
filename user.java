public class User {
    private String username;
    private String password;
    private boolean locked;
    private int failedAttempts;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.locked = false;
        this.failedAttempts = 0;
    }

    public boolean authenticate(String password) {
        if (locked) {
            return false;
        }
        if (password.equals(this.password)) {
            failedAttempts = 0;
            return true;
        } else {
            failedAttempts++;
            if (failedAttempts >= 3) {
                lockUser();
            }
            return false;
        }
    }

    public boolean isLocked() {
        return locked;
    }

    public void resetPassword(String newPassword) {
        this.password = newPassword;
        if (locked) {
            unlockUser();
        }
    }

    public void lockUser() {
        locked = true;
    }

    public void unlockUser() {
        locked = false;
    }
}

class MockUserSuccess19316 extends User {
    public MockUserSuccess19316(String username, String password) {
        super(username, password);
    }

    @Override
    public boolean authenticate(String password) {
        return true;
    }
}

class MockUserFail19316 extends User {
    public MockUserFail19316(String username, String password) {
        super(username, password);
    }

    @Override
    public boolean authenticate(String password) {
        return false;
    }
}






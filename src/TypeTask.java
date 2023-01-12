public enum TypeTask {
    CMD_PERSONALY("0"), CMD_WORK("1");

    public static TypeTask findByVoiceCommand(String voiceCommand) {
        for (TypeTask task : values()) {
            if (task.getVoiceCommand().equals(voiceCommand)) {
                return task;
            }

        }
        return null;
    }

    private String voiceTask;

    TypeTask(String voiceCommand) {
        this.voiceTask = voiceCommand;
    }

    public String getVoiceCommand() {
        return voiceTask;
    }
}

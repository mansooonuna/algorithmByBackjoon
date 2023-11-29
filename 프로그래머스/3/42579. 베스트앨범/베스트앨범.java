import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genreMap = new HashMap<>();
        HashMap<String, ArrayList<Music>> musicMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            int play = plays[i];
            String genre = genres[i];

            genreMap.put(genre, genreMap.getOrDefault(genre, 0) + play);
            if (!musicMap.containsKey(genre)) {
                musicMap.put(genre, new ArrayList<>());
            }
            musicMap.get(genre).add(new Music(i, play));
        }

        List<String> keySetList = new ArrayList<>(genreMap.keySet());
        Collections.sort(keySetList, (o1, o2) -> (genreMap.get(o2).compareTo(genreMap.get(o1))));

        ArrayList<Integer> bestAlbum = new ArrayList<>();
        for (String key : keySetList) {
            ArrayList<Music> musicList = musicMap.get(key);
            Collections.sort(musicList);

            bestAlbum.add(musicList.get(0).id);
            if (musicList.size() > 1) {
                bestAlbum.add(musicList.get(1).id);
            }
        }

        int[] answer = new int[bestAlbum.size()];
        for (int i = 0; i < bestAlbum.size(); i++) {
            answer[i] = bestAlbum.get(i);
        }

        return answer;
    }

    class Music implements Comparable<Music> {
        int id, play;

        Music(int id, int play) {
            this.id = id;
            this.play = play;
        }

        @Override
        public int compareTo(Music other) {
            if (this.play == other.play) {
                return this.id - other.id;
            } else {
                return other.play - this.play;
            }
        }
    }
}
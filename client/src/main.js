import App from "./App.svelte";

let characters = [
  { id: 1, text: `Father Rhinehardt` },
  { id: 2, text: `Professor Longfellow` },
  { id: 3, text: `Peter Akimoto` },
  { id: 4, text: `Brandon Jaspers` },
  { id: 5, text: `Jenny LeClerc` },
  { id: 6, text: `Heather Granville` },
  { id: 7, text: `Vivian Lopez` },
  { id: 8, text: `Madame Zostra` },
  { id: 9, text: `Darrin "Flash" Williams` },
  { id: 10, text: `Ox Bellows` },
  { id: 11, text: `Zoe Ingstrom` },
  { id: 12, text: `Miss Dubourde` },
];

const app = new App({
  target: document.body,
  props: {
    name: "Player",
  },
});

export default app;

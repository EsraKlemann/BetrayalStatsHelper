import { writable } from "svelte/store";

const storedChar = localStorage.getItem(selected.id);

export const char = writable(storedChar);

<script>
	export let name;

    let selected;

	let characters = [
		{ id: 1, text: `Father Rhinehardt` },
		{ id: 2, text: `Professor Longfellow` },
		{ id: 3, text: `Peter Akimoto` },
        { id: 4, text: `Brandon Jaspers` },
        { id: 5, text: `JennyLeClerc` },
        { id: 6, text: `Heather Granville` },
        { id: 7, text: `Vivian Lopez` },
        { id: 8, text: `Madame Zostra` },
        { id: 9, text: `Darrin "Flash" Williams` },
        { id: 10, text: `Ox Bellows` },
        { id: 11, text: `Zoe Ingstrom` },
        { id: 12, text: `Miss Dubourde` }
	];


</script>



<main>
	<h1>Hello {name}!</h1>
	<p>Pick a character:</p>
    <select value={selected} on:change="{() => answer = ''}">
		{#each characters as character}
			<option value={character}>
				{character.text}
			</option>
		{/each}
	</select>
    <p>Naam</p>
    <p>Leeftijd</p>
    <p>Stat1</p>
    <p>Stat2</p>
    <p>Stat3</p>
    <p>Stat4</p>
</main>


<style>
	main {
		text-align: center;
		padding: 1em;
		max-width: 240px;
		margin: 0 auto;
	}

	h1 {
		color: #ff3e00;
		text-transform: uppercase;
		font-size: 4em;
		font-weight: 100;
	}

	@media (min-width: 640px) {
		main {
			max-width: none;
		}
	}
</style>

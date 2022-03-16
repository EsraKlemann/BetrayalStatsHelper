<script>
	export let name;
</script>

<main>
	<h1>Hello {name}!</h1>
	<p>Kies je karakter</p>
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

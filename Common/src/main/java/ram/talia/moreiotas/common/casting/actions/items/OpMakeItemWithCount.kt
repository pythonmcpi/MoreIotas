package ram.talia.moreiotas.common.casting.actions.items

import at.petrak.hexcasting.api.casting.castables.ConstMediaAction
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment
import at.petrak.hexcasting.api.casting.getPositiveInt
import at.petrak.hexcasting.api.casting.asActionResult
import at.petrak.hexcasting.api.casting.iota.Iota
import net.minecraft.world.item.ItemStack
import ram.talia.moreiotas.api.asActionResult
import ram.talia.moreiotas.api.getItemType

object OpMakeItemWithCount : ConstMediaAction {
    override val argc = 2

    override fun execute(args: List<Iota>, env: CastingEnvironment): List<Iota> {
        val item = args.getItemType(0, argc) ?: return null.asActionResult
        val newCount = args.getPositiveInt(1, argc)

        return ItemStack(item, newCount).asActionResult
    }
}